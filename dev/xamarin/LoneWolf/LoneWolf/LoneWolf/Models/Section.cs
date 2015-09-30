using System.Collections.Generic;

namespace LoneWolf.Models
{
	public class Section
	{
		public string Number { get; set; }

		public string Body { get; set; }

		public IEnumerable<Choice> Choices { get; set; }
	}

	public class Choice
	{
		public string Number { get; set; }

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