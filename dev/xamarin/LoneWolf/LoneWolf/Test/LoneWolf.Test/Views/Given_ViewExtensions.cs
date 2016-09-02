using LoneWolf.Models;
using LoneWolf.Views;
using Machine.Specifications;

namespace LoneWolf.Test.Views
{
	[Subject(typeof(ViewExtensions))]
	public class Choice_GetCssClass
	{
		It should_be_enabled_for_Choice_with_no_Toggle = () => new Choice().GetCssClass().ShouldEqual("enabled");
		It should_be_enabled_for_Choice_with_enabled_Toggle = () => new Choice { Toggle = FakeChoiceToggle.On() }.GetCssClass().ShouldEqual("enabled");
		It should_be_disabled_for_Choice_with_disabled_Toggle = () => new Choice { Toggle = FakeChoiceToggle.Off() }.GetCssClass().ShouldEqual("disabled");
	}

	[Subject(typeof(ViewExtensions))]
	public class PrologueReference_GetCssClass
	{
		It should_be_enabled_for_valid_PrologueReference = () => PrologueReference.TitlePage.GetCssClass().ShouldEqual("enabled");
		It should_be_disabled_for_PrologueReference_Null = () => PrologueReference.Null.GetCssClass().ShouldEqual("disabled");
		It should_be_disabled_for_null_PrologueReference = () => ((PrologueReference)null).GetCssClass().ShouldEqual("disabled");
	}
}