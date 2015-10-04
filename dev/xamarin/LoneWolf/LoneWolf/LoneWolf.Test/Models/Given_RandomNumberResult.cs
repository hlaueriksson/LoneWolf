using LoneWolf.Models;
using Machine.Specifications;

namespace LoneWolf.Test.Models
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
		It should_be_equatable_with_operator = () =>
		{
			(new RandomNumberResult(1) == new RandomNumberResult(1)).ShouldBeTrue();
			(new RandomNumberResult(1) == 1).ShouldBeTrue();
			(new RandomNumberResult(1) == new RandomNumberResult(2)).ShouldBeFalse();
			(new RandomNumberResult(1) == 2).ShouldBeFalse();
		};
		It should_be_inequatable_with_operator = () =>
		{
			(new RandomNumberResult(1) != new RandomNumberResult(1)).ShouldBeFalse();
			(new RandomNumberResult(1) != 1).ShouldBeFalse();
			(new RandomNumberResult(1) != new RandomNumberResult(2)).ShouldBeTrue();
			(new RandomNumberResult(1) != 2).ShouldBeTrue();
		};
	}
}