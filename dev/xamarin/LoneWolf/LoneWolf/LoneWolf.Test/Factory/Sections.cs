using System;
using System.Collections.Generic;
using System.IO;
using LoneWolf.Models;
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
				var model = GetSection(i);

				var json = model.TypedSerialize();

				var path = GetCurrentDirectory() + @"\..\..\Factory\Data\";
				Console.WriteLine(path);
				var name = $"sect{i.ToString().PadLeft(3, '0')}.json";

				File.WriteAllText(path + name, json);
			}
		};

		private static Section GetSection(int number)
		{
			var model = new Section
			{
				Number = number.ToString(),
				Body = Lorem.Words(100, 500, true, true),
				Choices = GetChoices()
			};
			return model;
		}

		private static IEnumerable<Choice> GetChoices()
		{
			var count = random.Next(3) + 1;

			for (var i = 0; i < count; i++)
			{
				yield return GetChoice();
			}
		}

		private static Choice GetChoice()
		{
			var number = random.Next(SectionCount);

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

			return result < 75 ? new ChoiceOn() : new ChoiceOff() as IChoiceToggle;
		}

		private static string GetCurrentDirectory()
		{
			return Path.GetDirectoryName(System.Reflection.Assembly.GetExecutingAssembly().GetName().CodeBase).Replace(@"file:\", string.Empty);
		}
	}
}