using System.Collections.Generic;
using LoneWolf.Models;

namespace LoneWolf.ViewModels
{
	public class MainViewModel : BaseViewModel
	{
		private IEnumerable<Book> _books;

		public IEnumerable<Book> Books
		{
			private set
			{
				if (Equals(_books, value)) return;

				_books = value;
				OnPropertyChanged();
			}
			get { return _books; }
		}

		public MainViewModel()
		{
			Books = new[]
			{
				new Book {Number = "01", Name = "Flight from the Dark", Status = BookStatus.Available},
				new Book {Number = "02", Name = "Fire on the Water", Status = BookStatus.Unavailable}
			};
		}
	}
}