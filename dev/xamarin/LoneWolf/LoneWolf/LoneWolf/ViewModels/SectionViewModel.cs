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
			}
			get { return _section; }
		}

		public HtmlWebViewSource Source
		{
			set
			{
				if (Equals(_source, value)) return;

				_source = value;
				OnPropertyChanged();
			}
			get { return _source; }
		}

		public SectionViewModel()
		{
			Section = new Section { Number = "1" };
			Source = new HtmlWebViewSource
			{
				Html =
@"<html><body>
<h1>1</h1>
<p>Your life and your quest end here.</p>
<p>Turn to <a href='hybrid:section/165'>165</a></p>
</body></html>"
			};
		}
	}
}