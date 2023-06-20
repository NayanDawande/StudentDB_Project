import { useEffect, useState } from 'react';
import StudentForm from './components/StudentForm';
import StudentList from './components/StudentList';

const App = () => {
  const [students, setStudents] = useState([]);

  // Fetch all students on component mount
  useEffect(() => {
    fetchStudents();
  }, []);

  const fetchStudents = async () => {
    try {
      const response = await fetch('/');
      const data = await response.json();
      setStudents(data);
    } catch (error) {
      console.error('Error fetching students:', error);
    }
  };

  const addStudent = async (student) => {
    try {
      const response = await fetch('/add', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(student),
      });
      const data = await response.json();
      setStudents([...students, data]);
    } catch (error) {
      console.error('Error adding student:', error);
    }
  };

  return (
    <div>
      <h1>Student Data Management</h1>
      <StudentForm onSubmit={addStudent} />
      <StudentList students={students} />
    </div>
  );
};

export default App;
