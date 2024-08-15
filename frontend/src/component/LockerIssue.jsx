import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';

const LockerIssueForm = () => {
    const navigate = useNavigate();

    const handleLogout = () => {
      navigate('/Login')
      };

      const handleHome = () => {
        navigate('/Home');
      };

  const [formData, setFormData] = useState({
    accountNo: '',
    issueDate: '',
    validDateFrom: '',
    validDateTo: '',
    lockerId: '',
  });

  useEffect(() => {
    // Set the issue date to today's date when the component mounts
    const today = new Date().toISOString().split('T')[0];
    setFormData(prevState => ({
      ...prevState,
      issueDate: today
    }));
  }, []);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData(prevState => ({
      ...prevState,
      [name]: value
    }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log('Form submitted:', formData);
    // Add your form submission logic here
  };

  const handleView = () => {
    console.log('View button clicked');
    // Add your view logic here
  };

  const handleUpdate = () => {
    console.log('Update button clicked');
    // Add your update logic here
  };

  const handleDelete = () => {
    console.log('Delete button clicked');
    // Add your delete logic here
  };

  return (
    <div className="min-h-screen bg-gray-100 p-8">
      <div className="max-w-2xl mx-auto bg-white rounded-lg shadow-md p-8">
        <div className="flex justify-end mb-6">
          <button className="bg-red-500 hover:bg-red-600 text-white font-semibold py-2 px-4 rounded-lg transition duration-300 ease-in-out transform hover:scale-105"
          onClick={handleDelete}
          >
            Logout
          </button>
          <button 
           className="bg-blue-500 hover:bg-blue-600 text-white font-semibold py-2 px-4 rounded-lg transition duration-300 ease-in-out transform hover:scale-105"
           onClick={handleHome}
          >
           Home
          </button>
        </div>
        <h2 className="text-2xl font-bold text-gray-800 mb-6">Locker Issue</h2>
        <form onSubmit={handleSubmit}>
          <div className="mb-4">
            <label htmlFor="accountNo" className="block text-gray-700 font-semibold mb-2">Account No</label>
            <input
              type="number"
              id="accountNo"
              name="accountNo"
              value={formData.accountNo}
              onChange={handleChange}
              className="w-full px-3 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500"
              required
            />
          </div>
          <div className="mb-4">
            <label htmlFor="issueDate" className="block text-gray-700 font-semibold mb-2">Issue Date (Today's Date)</label>
            <input
              type="date"
              id="issueDate"
              name="issueDate"
              value={formData.issueDate}
              readOnly
              className="w-full px-3 py-2 border border-gray-300 rounded-md bg-gray-100"
            />
          </div>
          <div className="mb-4">
            <label htmlFor="validDateFrom" className="block text-gray-700 font-semibold mb-2">Valid Date From</label>
            <input
              type="date"
              id="validDateFrom"
              name="validDateFrom"
              value={formData.validDateFrom}
              onChange={handleChange}
              className="w-full px-3 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500"
              required
            />
          </div>
          <div className="mb-4">
            <label htmlFor="validDateTo" className="block text-gray-700 font-semibold mb-2">Valid Date To</label>
            <input
              type="date"
              id="validDateTo"
              name="validDateTo"
              value={formData.validDateTo}
              onChange={handleChange}
              className="w-full px-3 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500"
              required
            />
          </div>
          <div className="mb-6">
            <label htmlFor="lockerId" className="block text-gray-700 font-semibold mb-2">Locker Id</label>
            <input
              type="number"
              id="lockerId"
              name="lockerId"
              value={formData.lockerId}
              onChange={handleChange}
              className="w-full px-3 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500"
              required
            />
          </div>
          <div className="flex justify-center space-x-4">
            <button
              type="submit"
              className="bg-blue-500 hover:bg-blue-600 text-white font-semibold py-2 px-6 rounded-lg transition duration-300 ease-in-out transform hover:scale-105"
            >
              Submit
            </button>
            <button
              type="button"
              onClick={handleView}
              className="bg-green-500 hover:bg-green-600 text-white font-semibold py-2 px-6 rounded-lg transition duration-300 ease-in-out transform hover:scale-105"
            >
              View
            </button>
            <button
              type="button"
              onClick={handleUpdate}
              className="bg-yellow-500 hover:bg-yellow-600 text-white font-semibold py-2 px-6 rounded-lg transition duration-300 ease-in-out transform hover:scale-105"
            >
              Update
            </button>
            <button
              type="button"
              onClick={handleDelete}
              className="bg-red-500 hover:bg-red-600 text-white font-semibold py-2 px-6 rounded-lg transition duration-300 ease-in-out transform hover:scale-105"
            >
              Delete
            </button>
          </div>
        </form>
      </div>
    </div>
  );
};

export default LockerIssueForm;