using LoneWolf.Models;
using Machine.Specifications;

namespace LoneWolf.Test.Models
{
	public class Given_PrologueReference
	{
		[Subject(typeof(PrologueReference))]
		public class Conversion_operators
		{
			It should_convert_PrologueReference_to_string = () =>
			{
				string result = new PrologueReference("title");
				result.ShouldEqual("title");
			};

			It should_convert_string_to_PrologueReference = () =>
			{
				PrologueReference result = "title";
				result.Value.ShouldEqual("title");
			};
		}

		[Subject(typeof(PrologueReference))]
		public class Equals
		{
			It should_be_equatable_with_PrologueReference = () =>
			{
				new PrologueReference("title").Equals(new PrologueReference("title")).ShouldBeTrue();
				new PrologueReference("title").Equals(new PrologueReference("dedicate")).ShouldBeFalse();
				new PrologueReference("title").Equals((PrologueReference)null).ShouldBeFalse();
			};
			It should_be_equatable_with_string = () =>
			{
				new PrologueReference("title").Equals("title").ShouldBeTrue();
				new PrologueReference("title").Equals("dedicate").ShouldBeFalse();
				new PrologueReference("title").Equals((string)null).ShouldBeFalse();
			};
			It should_be_equatable_with_operator = () =>
			{
				(new PrologueReference("title") == new PrologueReference("title")).ShouldBeTrue();
				(new PrologueReference("title") == "title").ShouldBeTrue();
				(new PrologueReference("title") == new PrologueReference("dedicate")).ShouldBeFalse();
				(new PrologueReference("title") == "dedicate").ShouldBeFalse();
				(PrologueReference.TitlePage == new PrologueReference("title")).ShouldBeTrue();
				(PrologueReference.Dedication == new PrologueReference("title")).ShouldBeFalse();
			};
			It should_be_inequatable_with_operator = () =>
			{
				(new PrologueReference("title") != new PrologueReference("title")).ShouldBeFalse();
				(new PrologueReference("title") != "title").ShouldBeFalse();
				(new PrologueReference("title") != new PrologueReference("dedicate")).ShouldBeTrue();
				(new PrologueReference("title") != "dedicate").ShouldBeTrue();
				(PrologueReference.TitlePage != new PrologueReference("title")).ShouldBeFalse();
				(PrologueReference.Dedication != new PrologueReference("title")).ShouldBeTrue();
			};
		}
	}
}