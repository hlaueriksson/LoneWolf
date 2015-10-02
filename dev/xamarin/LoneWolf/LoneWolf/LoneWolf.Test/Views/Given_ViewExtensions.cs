using FakeItEasy;
using LoneWolf.Models;
using LoneWolf.Views;
using Machine.Specifications;

namespace LoneWolf.Test.Views
{
	[Subject(typeof(ViewExtensions))]
	public class Choice_GetCssClass
	{
		It should_be_enabled_for_Choice_with_no_Toggle = () => new Choice().GetCssClass().ShouldEqual("enabled");
		It should_be_enabled_for_Choice_with_enabled_Toggle = () => new Choice { Toggle = ToggleOn() }.GetCssClass().ShouldEqual("enabled");
		It should_be_disabled_for_Choice_with_disabled_Toggle = () => new Choice { Toggle = ToggleOff() }.GetCssClass().ShouldEqual("disabled");

		private static IChoiceToggle ToggleOn() => FakeToggle(true);

		private static IChoiceToggle ToggleOff() => FakeToggle(false);

		private static IChoiceToggle FakeToggle(bool enabled)
		{
			var fake = A.Fake<IChoiceToggle>();
			A.CallTo(() => fake.IsEnabled()).Returns(enabled);

			return fake;
		}
	}
}