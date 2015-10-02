using LoneWolf.Models;
using LoneWolf.Models.Book01;
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

				Source = new HtmlWebViewSource
				{
					Html = GetHtml(),
					BaseUrl = DependencyService.Get<IBaseUrl>().Get()
				};
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

		private string GetHtml()
		{
			if (Section == null) return string.Empty;

			var html = GenerateHtml();

			return System.Net.WebUtility.HtmlDecode(html);
		}

		private string GenerateHtml()
		{
			switch (Section.Number)
			{
				case "0":
					return new Book01Section000View { Model = Section as Section000 }.GenerateString();
				default:
					return new SectionView { Model = Section }.GenerateString();
			}
		}
	}
}