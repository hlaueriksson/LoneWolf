using LoneWolf.Models;
using Machine.Specifications;

namespace LoneWolf.Test.Views
{
	public class Given_SectionView
	{
		[Subject(typeof(SectionView))]
		public class GenerateString
		{
			static SectionView subject;

			Establish context = () =>
			{
				subject = new SectionView();
			};

			It should_render_valid_model = () =>
			{
				subject.Model = new Section
				{
					Number = "1",
					Choices = new[]
					{
						new Choice {Number = "2", Toggle = FakeChoiceToggle.On()},
						new Choice {Number = "3", Toggle = FakeChoiceToggle.Off()}
					}
				};
				var result = subject.GenerateString();

				result.ShouldNotBeEmpty();
				result.ShouldContain("id=\"2\" class=\"enabled\"");
				result.ShouldContain("id=\"3\" class=\"disabled\"");
			};
		}
	}
}