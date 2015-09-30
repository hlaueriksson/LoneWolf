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

			var template = new SectionView { Model = Section };
			var html = template.GenerateString();

			return System.Net.WebUtility.HtmlDecode(html);
		}
	}
}