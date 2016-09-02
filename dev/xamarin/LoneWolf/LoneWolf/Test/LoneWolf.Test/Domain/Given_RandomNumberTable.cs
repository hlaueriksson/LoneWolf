using LoneWolf.Domain;
using LoneWolf.Models;
using Machine.Fakes;
using Machine.Specifications;

namespace LoneWolf.Test.Domain
{
	[Subject(typeof(RandomNumberTable))]
	public class Next : WithSubject<RandomNumberTable>
	{
		Establish context = () => The<IRandom>().WhenToldTo(x => x.Next(10)).Return(1);

		It should_return_the_next_random_number = () => Subject.Next().ShouldEqual((RandomNumberResult)1);
	}
}