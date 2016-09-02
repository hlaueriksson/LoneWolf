using LoneWolf.Models;
using Machine.Specifications;

namespace LoneWolf.Test.Models
{
	[Subject(typeof(HtmlToggleExtensions))]
	public class Given_HtmlToggleExtensions
	{
		public class Disable_id
		{
			It should_disable_matching_id = () => " id=\"CombatSkill\" class=\"enabled\">".Disable("CombatSkill").ShouldEqual(" id=\"CombatSkill\" class=\"disabled\">");
			It should_not_disable_non_matching_id = () => " id=\"CombatSkill\" class=\"enabled\">".Disable("Endurance").ShouldEqual(" id=\"CombatSkill\" class=\"enabled\">");
		}

		public class Disable_id_toggle
		{
			It should_disable_matching_id = () => " id=\"CombatSkill\" class=\"enabled\">".Disable("CombatSkill", () => true).ShouldEqual(" id=\"CombatSkill\" class=\"disabled\">");
			It should_not_disable_non_matching_id = () => " id=\"CombatSkill\" class=\"enabled\">".Disable("Endurance", () => true).ShouldEqual(" id=\"CombatSkill\" class=\"enabled\">");
			It should_not_disable_false_toggle_func = () => " id=\"CombatSkill\" class=\"enabled\">".Disable("CombatSkill", () => false).ShouldEqual(" id=\"CombatSkill\" class=\"enabled\">");
		}

		public class Select_id_toggle
		{
			It should_select_matching_id = () => " id=\"Camouflage\" class=\"enabled\">".Select("Camouflage", () => true).ShouldEqual(" id=\"Camouflage\" class=\"selected\">");
			It should_not_select_non_matching_id = () => " id=\"Camouflage\" class=\"enabled\">".Select("Weaponskill", () => true).ShouldEqual(" id=\"Camouflage\" class=\"enabled\">");
			It should_not_select_false_toggle_func = () => " id=\"Camouflage\" class=\"enabled\">".Select("Camouflage", () => false).ShouldEqual(" id=\"Camouflage\" class=\"enabled\">");
		}
	}
}