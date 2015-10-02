using System;
using System.Collections.Generic;
using System.IO;
using LoneWolf.Models;
using LoneWolf.Models.Book01;
using LoremNET;
using Machine.Specifications;

namespace LoneWolf.Test.Factory
{
	[Subject("Generate")]
	public class Sections
	{
		static Random random;
		const int SectionCount = 10;

		Establish context = () =>
		{
			random = new Random();
		};

		It write_files_to_disk = () =>
		{
			Console.WriteLine();

			for (var i = 0; i < SectionCount; i++)
			{
				var model = i == 0 ? GetSection000(i) : GetSection(i);

				var json = model.TypedSerialize();

				var path = GetCurrentDirectory() + @"\..\..\Factory\Data\";
				var name = $"sect{i.ToString().PadLeft(3, '0')}.json";

				File.WriteAllText(path + name, json);
			}
		};

		private static Section GetSection(int number)
		{
			return new Section
			{
				Number = number.ToString(),
				Body = Lorem.Words(100, 500, true, true),
				Choices = GetChoices(number)
			};
		}

		private static Section000 GetSection000(int number)
		{
			return new Section000
			{
				Number = number.ToString(),
				Body = Lorem.Words(100, 500, true, true),
				Choices = GetChoices(number),
				Foo = "Bar"
			};
		}

		private static IEnumerable<Choice> GetChoices(int parent)
		{
			var count = random.Next(2) + 2;
			var numbers = GetNumbers(parent, count);

			for (var i = 0; i < count; i++)
			{
				yield return GetChoice(numbers[i]);
			}
		}

		private static List<int> GetNumbers(int parent, int count)
		{
			var numbers = new List<int>();
			for (var i = 0; i < count; i++)
			{
				var number = parent;
				while (number == parent || numbers.Contains(number))
				{
					number = random.Next(SectionCount);
				}
				numbers.Add(number);
			}
			return numbers;
		}

		private static Choice GetChoice(int number)
		{
			return new Choice
			{
				Number = number.ToString(),
				Body = GetBody(number),
				Toggle = GetToggle()
			};
		}

		private static string GetBody(int number)
		{
			var text = Lorem.Words(10, 20, true, true);
			var route = "hybrid:section";

			return $"<p class=\"choice\">{text} <a href=\"{route}/{number}\">turn to {number}</a>.</p>";
		}

		private static IChoiceToggle GetToggle()
		{
			var result = random.Next(100);

			return result < 80 ? new ChoiceOn() : new ChoiceOff() as IChoiceToggle;
		}

		private static string GetCurrentDirectory()
		{
			return Path.GetDirectoryName(System.Reflection.Assembly.GetExecutingAssembly().GetName().CodeBase).Replace(@"file:\", string.Empty);
		}
	}
}