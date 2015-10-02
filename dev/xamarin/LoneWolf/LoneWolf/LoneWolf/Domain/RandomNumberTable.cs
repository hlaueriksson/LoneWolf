using System;

namespace LoneWolf.Domain
{
	public class RandomNumberTable
	{
		private readonly IRandom _random;

		public RandomNumberTable(IRandom random)
		{
			_random = random;
		}

		public RandomNumberResult Next()
		{
			return new RandomNumberResult(_random.Next(10));
		}
	}

	public class RandomNumberResult : IEquatable<RandomNumberResult>, IEquatable<int>
	{
		private int Value { get; }

		public RandomNumberResult(int value)
		{
			Value = value;
		}

		public static implicit operator int (RandomNumberResult value)
		{
			return value.Value;
		}

		public static implicit operator RandomNumberResult(int value)
		{
			return new RandomNumberResult(value);
		}

		public bool Equals(RandomNumberResult other) => other != null && Value == other.Value;

		public bool Equals(int other) => Value == other;

		public override string ToString() => Value.ToString();
	}

	public interface IRandom
	{
		int Next(int maxValue);
	}

	public class RandomFacade : IRandom
	{
		private readonly Random _random;

		public RandomFacade()
		{
			_random = new Random();
		}

		public int Next(int maxValue)
		{
			return _random.Next(maxValue);
		}
	}
}