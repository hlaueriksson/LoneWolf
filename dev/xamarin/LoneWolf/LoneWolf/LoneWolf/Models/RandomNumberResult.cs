using System;
using System.Diagnostics;

namespace LoneWolf.Models
{
	[DebuggerDisplay("{Value}")]
	public class RandomNumberResult : IEquatable<RandomNumberResult>, IEquatable<int>
	{
		public int Value { get; }

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

		public static bool operator ==(RandomNumberResult a, RandomNumberResult b)
		{
			if (ReferenceEquals(a, b)) return true;
			if (((object)a == null) || ((object)b == null)) return false;

			return a.Value == b.Value;
		}

		public static bool operator !=(RandomNumberResult a, RandomNumberResult b) => !(a == b);

		public override int GetHashCode() => Value.GetHashCode();

		public override string ToString() => Value.ToString();
	}
}