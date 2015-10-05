using LoneWolf.Models;
using Machine.Specifications;

namespace LoneWolf.Test.Models
{
	public class Given_KaiDisciplineExtensions
	{
		[Subject(typeof(KaiDisciplineExtensions))]
		public class GetKaiDiscipline
		{
			It should_return_the_matching_KaiDiscipline = () => "AnimalKinship".GetKaiDiscipline().ShouldEqual(KaiDiscipline.AnimalKinship);
			It should_return_None_if_invalid = () => "Foo".GetKaiDiscipline().ShouldEqual(KaiDiscipline.None);
		}
	}
}