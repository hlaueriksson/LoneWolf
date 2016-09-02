using System;
using LoneWolf.Models;

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