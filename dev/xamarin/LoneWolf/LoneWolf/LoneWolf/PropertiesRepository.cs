using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using Xamarin.Forms;

namespace LoneWolf
{
	public interface IPropertiesRepository<T>
	{
		void Add(T model);
		T Get();
		void Update(T model);
		void Update(Action<T> action);
		bool Remove();
		bool Exists();
		Task SaveAsync();
	}

	public class PropertiesRepository<T> : IPropertiesRepository<T> where T : class
	{
		private IDictionary<string, object> Properties => Application.Current.Properties;

		private string Key => typeof(T).Name;

		public void Add(T model)
		{
			Properties.Add(Key, model);
		}

		public T Get()
		{
			return Properties[Key] as T;
		}

		public void Update(T model)
		{
			Properties[Key] = model;
		}

		public void Update(Action<T> action)
		{
			var model = Get();

			action(model);

			Update(model);
		}

		public bool Remove()
		{
			return Properties.Remove(Key);
		}

		public bool Exists()
		{
			return Properties.ContainsKey(Key);
		}

		public Task SaveAsync()
		{
			return Application.Current.SavePropertiesAsync();
		}
	}
}