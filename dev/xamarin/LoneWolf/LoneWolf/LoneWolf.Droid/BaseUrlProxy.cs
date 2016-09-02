using LoneWolf.Droid;
using Xamarin.Forms;

[assembly: Dependency(typeof(BaseUrlProxy))]
namespace LoneWolf.Droid
{
	public class BaseUrlProxy : IBaseUrl
	{
		public string Get()
		{
			return "file:///android_asset/";
		}
	}
}