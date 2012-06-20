package com.hoffenkloffen.lonewolf.controllers.section;

import com.hoffenkloffen.lonewolf.controllers.SectionResourceManager;
import com.hoffenkloffen.lonewolf.controllers.Combat;
import com.hoffenkloffen.lonewolf.controllers.SectionState;
import com.hoffenkloffen.lonewolf.controllers.javascript.injections.JavascriptInjection;
import com.hoffenkloffen.lonewolf.controllers.interfaces.ChoiceJavascriptInterface;
import com.hoffenkloffen.lonewolf.controllers.interfaces.JavascriptInterface;
import com.hoffenkloffen.lonewolf.controllers.section.rules.SectionRule;
import com.hoffenkloffen.lonewolf.models.Illustration;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Section {

    private String number;

    private SectionResourceManager resourceManager;

    private List<JavascriptInterface> javascriptInterfaces = new ArrayList<JavascriptInterface>();
    private Map<String, SectionState> states = new Hashtable<String, SectionState>();
    private List<SectionRule> rules = new ArrayList<SectionRule>();
    private Combat combat;

    public Section(String number) {
        setNumber(number);
    }

    public String getNumber() {
        return number;
    }

    private void setNumber(String number) {
        this.number = number;
    }

    public Section set(SectionResourceManager resourceManager) {
        this.resourceManager = resourceManager;

        return this;
    }

    public Section add(JavascriptInterface controller) {
        javascriptInterfaces.add(controller);

        return this;
    }

    public Collection<JavascriptInterface> getJavascriptInterfaces() {
        return javascriptInterfaces;
    }

    public Section when(SectionRule rule) {
        rules.add(rule);

        return this;
    }

    public Collection<SectionRule> getRules() {
        return rules;
    }

    public Section add(SectionState state) {
        states.put(state.getClass().getSimpleName(), state);

        return this;
    }

    public Collection<SectionState> getStates() {
        return states.values();
    }

    public Section set(Combat combat) {
        this.combat = combat;

        return this;
    }

    public Combat getCombat() {
        return combat;
    }

    public List<String> getChoices() {
        List<String> result = new ArrayList<String>();

        String content = resourceManager.getHtmlContent(number);

        Pattern p = Pattern.compile("javascript:Choice.turnTo\\((.+)\\);", Pattern.MULTILINE);
        Matcher m = p.matcher(content);

        while (m.find()) {
            result.add(m.group(1));
        }

        return result;
    }

    public List<Illustration> getIllustrations() {
        List<Illustration> result = new ArrayList<Illustration>();

        String content = resourceManager.getHtmlContent(number);

        if(content == null) return result;

        Pattern p = Pattern.compile("<img alt=\"\" src=\"(.+)\" />", Pattern.MULTILINE);
        Matcher m = p.matcher(content);

        while (m.find()) {
            result.add(new Illustration(m.group(1)));
        }

        return result;
    }

    public String getContent()
    {
        String template = resourceManager.getHtmlTemplate();
        String title = resourceManager.getHtmlTitle() + ": " + number;
        String revised = Long.toString(System.currentTimeMillis());
        String content = resourceManager.getHtmlContent(number);

        if(template == null) return null;

        // Base64 images
        for (Illustration illustration : getIllustrations()) {
            String data = resourceManager.getBase64Image(illustration);
            content = content.replace(illustration.getFilename(), "data:image/png;base64," + data);
        }

        // Javascript injections
        StringBuilder javascript = new StringBuilder();

        for (JavascriptInjection javascriptInjection : getJavascriptInjections()) {
            javascript.append(javascriptInjection.getScript(getStates()));
        }

        return String.format(template, title, revised, content, javascript);
    }

    public String getMimeType()
    {
        return "text/html; charset=UTF-8";
    }

    public String getEncoding()
    {
        return "UTF-8";
    }

    public void enter()
    {
        // TODO: execute on enter commands
    }

    public void exit()
    {
        // TODO: execute on exit commands
    }

    private Iterable<SectionRule> getJavascriptInjectionRules() {
        List<SectionRule> result = new ArrayList<SectionRule>();

        for (SectionRule rule : getRules()) {
            if(rule.getJavascriptInjection() == null) continue;

            result.add(rule);
        }

        return result;
    }

    private Iterable<JavascriptInjection> getJavascriptInjections() {
        List<JavascriptInjection> result = new ArrayList<JavascriptInjection>();

        for (SectionRule rule : getJavascriptInjectionRules()) {
            if(!rule.match(getStates())) continue;

            result.add(rule.getJavascriptInjection());
        }

        return result;
    }

    @Override
    public String toString()
    {
        StringBuilder result = new StringBuilder();

        result.append(getNumber());
        result.append("\n");

        if(getJavascriptInterfaces().size() > 1) {
            result.append("\tJavascriptInterfaces; ");
            for (JavascriptInterface javascriptInterface : getJavascriptInterfaces()) {
                if((javascriptInterface instanceof ChoiceJavascriptInterface)) continue;

                result.append(javascriptInterface.getInterfaceName());
                result.append(", ");
            }
            result.append("\n");
        }

        if(!getRules().isEmpty()) {
            result.append("\tRules; ");
            for (SectionRule rule : getRules()) {
                result.append(rule.toString());
                result.append(", ");
            }
            result.append("\n");
        }

        if(!getIllustrations().isEmpty()) {
            result.append("\tIllustrations; ");
            for (Illustration illustration : getIllustrations()) {
                result.append(illustration.getFilename());
                result.append(", ");
            }
            result.append("\n");
        }

        return result.toString();
    }
}
