using System.Collections.Generic;
using System.Diagnostics;

namespace LoneWolf.Models
{
	[DebuggerDisplay("Section {Number}")]
	public class Section
	{
		public SectionReference Number { get; set; }

		public string Body { get; set; }

		public IEnumerable<Choice> Choices { get; set; }
	}

	[DebuggerDisplay("{Number}")]
	public class SectionReference
	{
		public string Number { get; }

		public SectionReference(string number)
		{
			Number = number;
		}

		public static implicit operator string (SectionReference value)
		{
			return value.Number;
		}

		public static implicit operator SectionReference(string value)
		{
			return new SectionReference(value);
		}

		public override string ToString()
		{
			return Number;
		}
	}

	[DebuggerDisplay("Turn to {Number}")]
	public class Choice
	{
		public SectionReference Number { get; set; }

		public string Body { get; set; }

		public IChoiceToggle Toggle { get; set; }
	}

	public interface IChoiceToggle
	{
		bool IsEnabled();
	}

	public class ChoiceOn : IChoiceToggle
	{
		public bool IsEnabled()
		{
			return true;
		}
	}

	public class ChoiceOff : IChoiceToggle
	{
		public bool IsEnabled()
		{
			return false;
		}
	}
}