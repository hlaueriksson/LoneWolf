using System;
using LoneWolf.Models;
using LoneWolf.ViewModels;
using Xamarin.Forms;

namespace LoneWolf.Views
{
	public partial class SectionPage : ContentPage
	{
		public SectionPage()
		{
			InitializeComponent();
		}

		private void Browser_OnNavigating(object sender, WebNavigatingEventArgs e)
		{
			Log("Browser_OnNavigating");

			e.Cancel = true;

			var number = GetSectionNumber(e.Url);

			var model = BindingContext as SectionViewModel;

			if (model == null) return;

			model.Section = GetSection(number);
		}

		private void Browser_OnNavigated(object sender, WebNavigatedEventArgs e)
		{
			Log("Browser_OnNavigated");
		}

		private string GetSectionNumber(string url)
		{
			return url.Replace("hybrid:section/", string.Empty);
		}

		private static Section GetSection(string number)
		{
			var random = new Random();
			var max = 250;

			return new Section
			{
				Number = number,
				Choices = new[]
				{
					new Choice { Number = random.Next(max).ToString() },
					new Choice { Number = random.Next(max).ToString() },
					new Choice { Number = random.Next(max).ToString() }
				}
			};
		}

		private static void Log(string message)
		{
			System.Diagnostics.Debug.WriteLine(message);
		}
	}
}