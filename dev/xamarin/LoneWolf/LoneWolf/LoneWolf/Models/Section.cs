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
	}
}