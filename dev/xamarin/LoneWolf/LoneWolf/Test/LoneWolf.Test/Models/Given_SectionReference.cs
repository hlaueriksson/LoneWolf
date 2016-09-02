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
				result.Value.ShouldEqual("1");
			};
		}

		[Subject(typeof(SectionReference))]
		public class Equals
		{
			It should_be_equatable_with_SectionReference = () =>
			{
				new SectionReference("1").Equals(new SectionReference("1")).ShouldBeTrue();
				new SectionReference("1").Equals(new SectionReference("2")).ShouldBeFalse();
				new SectionReference("1").Equals((SectionReference)null).ShouldBeFalse();
			};
			It should_be_equatable_with_string = () =>
			{
				new SectionReference("1").Equals("1").ShouldBeTrue();
				new SectionReference("1").Equals("2").ShouldBeFalse();
				new SectionReference("1").Equals((string)null).ShouldBeFalse();
			};
			It should_be_equatable_with_operator = () =>
			{
				(new SectionReference("1") == new SectionReference("1")).ShouldBeTrue();
				(new SectionReference("1") == "1").ShouldBeTrue();
				(new SectionReference("1") == new SectionReference("2")).ShouldBeFalse();
				(new SectionReference("1") == "2").ShouldBeFalse();
			};
			It should_be_inequatable_with_operator = () =>
			{
				(new SectionReference("1") != new SectionReference("1")).ShouldBeFalse();
				(new SectionReference("1") != "1").ShouldBeFalse();
				(new SectionReference("1") != new SectionReference("2")).ShouldBeTrue();
				(new SectionReference("1") != "2").ShouldBeTrue();
			};
		}
	}
}