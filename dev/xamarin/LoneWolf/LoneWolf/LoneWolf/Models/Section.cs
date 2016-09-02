using System;
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

	[DebuggerDisplay("{Value}")]
	public class SectionReference : IEquatable<SectionReference>, IEquatable<string>
	{
		public string Value { get; }

		public SectionReference(string value)
		{
			Value = value;
		}

		public static implicit operator string (SectionReference value)
		{
			return value.Value;
		}

		public static implicit operator SectionReference(string value)
		{
			return new SectionReference(value);
		}

		public bool Equals(SectionReference other) => other != null && Value == other.Value;

		public bool Equals(string other) => Value == other;

		public static bool operator ==(SectionReference a, SectionReference b)
		{
			if (ReferenceEquals(a, b)) return true;
			if (((object)a == null) || ((object)b == null)) return false;

			return a.Value == b.Value;
		}

		public static bool operator !=(SectionReference a, SectionReference b) => !(a == b);

		public override int GetHashCode() => Value.GetHashCode();

		public override string ToString() => Value;
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