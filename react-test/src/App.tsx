import axios from 'axios';
import React, { useEffect, useState } from 'react'

const DOMAIN = "http://localhost:8082";
const BOOK_API = "api/test/books";

interface GetBookListResponseDto {
  id: number;
  title: string;
  author: string;
  category: string;
}

type category = '인문' | '사회' | '과학기술' | '기타';

function App() {
  const [query, setQuery] = useState<category>('기타');

  const [category, setCategory] = useState<string>('');
  const [results, setResults] = useState<GetBookListResponseDto[]>([]);

  const handleButtonClick = (e: React.MouseEvent<HTMLButtonElement>) => {
    fetchBookData();
  };

  const fetchBookData = async () => {
    try {
        const response = await axios.get(`${DOMAIN}/${BOOK_API}/list`);

        const data = response.data.data;
  
        setResults(data);

    } catch(error) {
      console.error("Error fetching data: ", error);
    }
  };

  const fetchMenuData = async (category: string) => {
    if (category.trim()) {
      try {

        const response = await axios.get(
          `${DOMAIN}/${BOOK_API}/category`,
          { params: { category }}
        );

        const data = response.data.data;

        setResults(data);

      } catch (error) {
        console.error("Error fetching data: ", error);
      }
    }
  }

  const fetchMenuButtonData = async (category: string) => {
    if (category.trim()) {
      try {

        const response = await axios.get(
          `${DOMAIN}/${BOOK_API}/category`,
          { params: { category }}
        );

        const data = response.data.data;

        setResults(data);

      } catch (error) {
        console.error("Error fetching data: ", error);
      }
    }
  }

  useEffect(() => {
    fetchMenuData(category);
  }, [category]);

  useEffect(() => {
    fetchMenuButtonData(query);
  }, [query]);

  const handleCategoryButtonClick = (e:React.MouseEvent<HTMLButtonElement>) => {
    const selectCategory = e.currentTarget.value as category;
    setQuery(selectCategory);
  }

  return (
    <div>
      <button 
        onClick={handleButtonClick}
        style={{
          backgroundColor: '#3498db',
          color: '#fff',
          borderRadius: '5px',
          border: 'none',
          padding: '10px 20px',
          marginLeft: '5px',
          marginTop: '10px',
          cursor: 'pointer'
        }}
      >
        전체 조회
      </button>
      <button
        value='인문'
        onClick={handleCategoryButtonClick}
        style={{
          backgroundColor: '#3498db',
          color: '#fff',
          borderRadius: '5px',
          border: 'none',
          padding: '10px 20px',
          marginLeft: '5px',
          marginTop: '10px',
          cursor: 'pointer'
        }}
      >인문</button>
      <button
        value='사회'
        onClick={handleCategoryButtonClick}
        style={{
          backgroundColor: '#3498db',
          color: '#fff',
          borderRadius: '5px',
          border: 'none',
          padding: '10px 20px',
          marginLeft: '5px',
          marginTop: '10px',
          cursor: 'pointer'
        }}
      >사회</button>
      <button
        value='과학기술'
        onClick={handleCategoryButtonClick}
        style={{
          backgroundColor: '#3498db',
          color: '#fff',
          borderRadius: '5px',
          border: 'none',
          padding: '10px 20px',
          marginLeft: '5px',
          marginTop: '10px',
          cursor: 'pointer',
        }}
      >과학기술</button>
      <button
        value='기타'
        onClick={handleCategoryButtonClick}
        style={{
          backgroundColor: '#3498db',
          color: '#fff',
          borderRadius: '5px',
          border: 'none',
          padding: '10px 20px',
          marginLeft: '5px',
          marginTop: '10px',
          cursor: 'pointer'
        }}
      >기타</button>
      <ul style={{
        listStyle: 'none',
        padding: '5px',
      }}>
        {results.map((book) => (
          <li 
            key={book.id}
            style={{
              backgroundColor: '#ecf0f1',
              color: '#2c3e55',
              border: 'none',
              borderRadius: '20px',
              padding: '8px',
              paddingLeft: '20px',
              marginBottom: '15px',
              maxWidth: '400px'
            }}
          >
            {book.title}
            <br />
            {book.author}
            <br />
            {book.category}
          </li>
        ))}
      </ul>
    </div>
  )
}

export default App