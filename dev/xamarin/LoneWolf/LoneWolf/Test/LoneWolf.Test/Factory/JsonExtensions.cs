using Newtonsoft.Json;

namespace LoneWolf.Test.Factory
{
	public static class JsonExtensions
	{
		// http://stackoverflow.com/questions/15880574/json-net-how-to-deserialize-collection-of-interface-instances#answer-19710948
		public static T TypedDeserialize<T>(this string value) where T : class
		{
			if (value == null) return null;

			return JsonConvert.DeserializeObject<T>(value, new JsonSerializerSettings
			{
				TypeNameHandling = TypeNameHandling.Objects
			});
		}

		public static string TypedSerialize<T>(this T value) where T : class
		{
			return JsonConvert.SerializeObject(value, new JsonSerializerSettings
			{
				TypeNameHandling = TypeNameHandling.Objects,
				TypeNameAssemblyFormat = System.Runtime.Serialization.Formatters.FormatterAssemblyStyle.Simple
			});
		}
	}
}