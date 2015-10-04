using System.ComponentModel;
using System.Runtime.CompilerServices;
using LoneWolf.Annotations;
using Xamarin.Forms;

namespace LoneWolf.ViewModels
{
	public abstract class BaseViewModel : INotifyPropertyChanged
	{
		public event PropertyChangedEventHandler PropertyChanged;

		[NotifyPropertyChangedInvocator]
		protected void OnPropertyChanged([CallerMemberName] string propertyName = null)
		{
			PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));
		}
	}

	public abstract class BaseBrowserViewModel : BaseViewModel
	{
		private HtmlWebViewSource _source;

		public HtmlWebViewSource Source
		{
			protected set
			{
				if (Equals(_source, value)) return;

				_source = value;
				OnPropertyChanged();
			}
			get { return _source; }
		}

		protected HtmlWebViewSource GetHtmlWebViewSource()
		{
			return new HtmlWebViewSource
			{
				Html = GetHtml(),
				BaseUrl = DependencyService.Get<IBaseUrl>().Get()
			};
		}

		protected abstract string GenerateHtml();

		private string GetHtml()
		{
			var html = GenerateHtml();

			return System.Net.WebUtility.HtmlDecode(html);
		}
	}
}