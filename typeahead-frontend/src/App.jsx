import { useEffect, useState } from "react";
import "./App.css";

function App() {

  const [query, setQuery] = useState("");
  const [suggestions, setSuggestions] = useState([]);
  const [message, setMessage] = useState("");
  const [trending, setTrending] = useState([]);

  useEffect(() => {

    fetch("http://localhost:8080/api/search/trending")
      .then((res) => res.json())
      .then((data) => {
        setTrending(data);
      });

  }, []);

  useEffect(() => {

    if (!query.trim()) {
      setSuggestions([]);
      return;
    }

    const timeout = setTimeout(() => {

      fetch(`http://localhost:8080/api/search/suggest?q=${query}`)
        .then((res) => res.json())
        .then((data) => {
          setSuggestions(data);
        });

    }, 300);

    return () => clearTimeout(timeout);

  }, [query]);

  const handleSearch = async (searchText) => {

    const finalQuery = searchText || query;

    const response = await fetch("http://localhost:8080/api/search", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        query: finalQuery,
      }),
    });

    const data = await response.json();

    setMessage(data.message);
  };

  return (
    <div className="container">

      <h1>Typeahead Search System</h1>

      <div className="search-box">

        <input
          type="text"
          placeholder="Search here..."
          value={query}
          onChange={(e) => setQuery(e.target.value)}
        />

        <button onClick={() => handleSearch()}>
          Search
        </button>

      </div>

      {
        suggestions.length > 0 && (
          <ul className="suggestions">

            {
              suggestions.map((item, index) => (

                <li
                  key={index}
                  onClick={() => {
                    setQuery(item);
                    handleSearch(item);
                  }}
                >
                  {item}
                </li>
              ))
            }

          </ul>
        )
      }

      {
        message && (
          <p className="message">
            {message}
          </p>
        )
      }

      <div className="trending-section">

        <h2>Trending Searches</h2>

        <div className="trending-list">

          {
            trending.map((item, index) => (

              <span
                key={index}
                className="trending-item"
                onClick={() => {
                  setQuery(item);
                }}
              >
                {item}
              </span>
            ))
          }

        </div>

      </div>

    </div>
  );
}

export default App;