document.getElementById('get-weather').addEventListener('click', getWeather);

function getWeather() {
  const city = document.getElementById('city-input').value;
  if (!city) {
    alert('Please enter a city name.');
    return;
  }

  const apiKey = 'YOUR_API_KEY';  // Get your API key from OpenWeatherMap (https://openweathermap.org/api)
  const url = `https://api.openweathermap.org/data/2.5/weather?q=${city}&appid=${apiKey}&units=metric`;

  fetch(url)
    .then(response => response.json())
    .then(data => {
      if (data.cod === 200) {
        document.getElementById('city-name').textContent = data.name;
        document.getElementById('temperature').textContent = `Temperature: ${data.main.temp}°C`;
        document.getElementById('description').textContent = `Weather: ${data.weather[0].description}`;
        document.getElementById('humidity').textContent = `Humidity: ${data.main.humidity}%`;
        document.getElementById('wind-speed').textContent = `Wind Speed: ${data.wind.speed} m/s`;
      } else {
        alert('City not found!');
      }
    })
    .catch(error => {
      alert('Error fetching weather data.');
    });
      }
