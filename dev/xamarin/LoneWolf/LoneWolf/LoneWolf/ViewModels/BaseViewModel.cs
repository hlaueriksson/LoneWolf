using System;
using System.ComponentModel;
using System.Linq.Expressions;
using System.Runtime.CompilerServices;
using LoneWolf.Models;
using Xamarin.Forms;

namespace LoneWolf.ViewModels
{
	public abstract class BaseViewModel : INotifyPropertyChanged
	{
		public event PropertyChangedEventHandler PropertyChanged;

		protected void OnPropertyChanged([CallerMemberName] string propertyName = null)
		{
			PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));
		}

		protected void OnPropertyChanged<TProperty>(Expression<Func<TProperty>> projection)
		{
			var memberExpression = (MemberExpression)projection.Body;
			OnPropertyChanged(memberExpression.Member.Name);
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

		protected HtmlWebViewSource GetHtmlWebViewSource(IBrowserToggle toggle = null)
		{
			return new HtmlWebViewSource
			{
				Html = GetHtml(toggle),
				BaseUrl = DependencyService.Get<IBaseUrl>().Get()
			};
		}

		protected abstract string GenerateHtml();

		private string GetHtml(IBrowserToggle toggle)
		{
			var html = GenerateHtml();

			return toggle != null ? toggle.Execute(HtmlDecode(html)) : HtmlDecode(html);
		}

		private static string HtmlDecode(string html)
		{
			return System.Net.WebUtility.HtmlDecode(html);
		}
	}
}