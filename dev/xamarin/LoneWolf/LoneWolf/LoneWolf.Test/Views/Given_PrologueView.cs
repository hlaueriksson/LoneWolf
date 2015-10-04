using LoneWolf.Models;
using Machine.Specifications;

namespace LoneWolf.Test.Views
{
	public class Given_PrologueView
	{
		[Subject(typeof(PrologueView))]
		public class GenerateString
		{
			static PrologueView subject;

			Establish context = () =>
			{
				subject = new PrologueView();
			};

			It should_render_valid_model = () =>
			{
				subject.Model = new Prologue { Id = PrologueReference.TitlePage, Back = PrologueReference.Null, Forward = PrologueReference.Dedication };
				var result = subject.GenerateString();

				result.ShouldNotBeEmpty();
				result.ShouldContain("id=\"back\" class=\"disabled\"");
				result.ShouldContain("id=\"forward\" class=\"enabled\"");
			};
		}
	}
}