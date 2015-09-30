using LoneWolf.Models;
using Machine.Specifications;

namespace LoneWolf.Test.Views
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
			subject.Model = new Section { Number = "1", Choices = new[] { new Choice { Number = "2" } } };
			subject.GenerateString().ShouldNotBeEmpty();
		};
	}
}