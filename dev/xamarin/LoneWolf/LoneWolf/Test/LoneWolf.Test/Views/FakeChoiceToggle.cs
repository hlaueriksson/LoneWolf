using FakeItEasy;
using LoneWolf.Models;

namespace LoneWolf.Test.Views
{
	public static class FakeChoiceToggle
	{
		public static IChoiceToggle On() => FakeToggle(true);

		public static IChoiceToggle Off() => FakeToggle(false);

		private static IChoiceToggle FakeToggle(bool enabled)
		{
			var fake = A.Fake<IChoiceToggle>();
			A.CallTo(() => fake.IsEnabled()).Returns(enabled);

			return fake;
		}
	}
}