namespace LoneWolf.Models
{
	public class Book
	{
		public string Number { get; set; }

		public string Name { get; set; }

		public BookStatus Status { get; set; }
	}

	public enum BookStatus
	{
		Available,
		Unavailable
	}
}