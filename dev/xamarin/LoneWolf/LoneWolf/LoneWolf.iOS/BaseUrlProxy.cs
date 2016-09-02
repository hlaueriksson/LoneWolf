using Foundation;
using LoneWolf.iOS;
using Xamarin.Forms;

[assembly: Dependency(typeof(BaseUrlProxy))]
namespace LoneWolf.iOS
{
	public class BaseUrlProxy : IBaseUrl
	{
		public string Get()
		{
			return NSBundle.MainBundle.BundlePath;
		}
	}
}