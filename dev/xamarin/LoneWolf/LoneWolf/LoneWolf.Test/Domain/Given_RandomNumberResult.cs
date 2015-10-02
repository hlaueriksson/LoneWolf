using LoneWolf.Domain;
using Machine.Specifications;

namespace LoneWolf.Test.Domain
{
	[Subject(typeof(RandomNumberResult))]
	public class Equals
	{
		It should_be_equatable_with_RandomNumberResult = () =>
		{
			new RandomNumberResult(1).Equals(new RandomNumberResult(1)).ShouldBeTrue();
			new RandomNumberResult(1).Equals(new RandomNumberResult(2)).ShouldBeFalse();
			new RandomNumberResult(1).Equals(null).ShouldBeFalse();
		};
		It should_be_equatable_with_int = () =>
		{
			new RandomNumberResult(1).Equals(1).ShouldBeTrue();
			new RandomNumberResult(1).Equals(2).ShouldBeFalse();
		};
	}
}