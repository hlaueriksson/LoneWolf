using LoneWolf.Models;
using Xamarin.Forms;

namespace LoneWolf.ViewModels
{
	public class SectionViewModel : BaseViewModel
	{
		private Section _section;
		private HtmlWebViewSource _source;

		public Section Section
		{
			set
			{
				if (Equals(_section, value)) return;

				_section = value;
				OnPropertyChanged();

				Source = new HtmlWebViewSource { Html = GetHtml() };
			}
			get { return _section; }
		}

		public HtmlWebViewSource Source
		{
			private set
			{
				if (Equals(_source, value)) return;

				_source = value;
				OnPropertyChanged();
			}
			get { return _source; }
		}

		public SectionViewModel()
		{
			Section = new Section
			{
				Number = "1",
				Choices = new[]
				{
					new Choice { Number = "165" }
				}
			};
		}

		private string GetHtml()
		{
			var template = new SectionView { Model = Section };

			return template.GenerateString();
		}
	}
}