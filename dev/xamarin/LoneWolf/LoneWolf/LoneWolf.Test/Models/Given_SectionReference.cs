using LoneWolf.Models;
using Machine.Specifications;

namespace LoneWolf.Test.Models
{
	public class Given_SectionReference
	{
		[Subject(typeof(SectionReference))]
		public class Conversion_operators
		{
			It should_convert_SectionReference_to_string = () =>
			{
				string result = new SectionReference("1");
				result.ShouldEqual("1");
			};

			It should_convert_string_to_SectionReference = () =>
			{
				SectionReference result = "1";
				result.Number.ShouldEqual("1");
			};
		}
	}
}