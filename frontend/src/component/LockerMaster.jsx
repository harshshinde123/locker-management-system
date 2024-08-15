import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

const LockerMasterForm = () => {
    const navigate = useNavigate();

    const handleLogout = () => {
      navigate('/Login')
      };

      const handleHome = () => {
        navigate('/Home');
      };

  const [formData, setFormData] = useState({
    lockerNumber: '',
    lockerSize: '',
    lockerStatus: '',
    lockerPrice: '',
    lockerKeyNumber: '',
  });

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
          onClick={handleLogout}
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
        <h2 className="text-2xl font-bold text-gray-800 mb-6">Locker Master</h2>
        <form onSubmit={handleSubmit}>
          <div className="mb-4">
            <label htmlFor="lockerNumber" className="block text-gray-700 font-semibold mb-2">Locker Number</label>
            <input
              type="number"
              id="lockerNumber"
              name="lockerNumber"
              value={formData.lockerNumber}
              onChange={handleChange}
              className="w-full px-3 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500"
              required
            />
          </div>
          <div className="mb-4">
            <label htmlFor="lockerSize" className="block text-gray-700 font-semibold mb-2">Locker Size</label>
            <select
              id="lockerSize"
              name="lockerSize"
              value={formData.lockerSize}
              onChange={handleChange}
              className="w-full px-3 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500"
              required
            >
              <option value="">Select Size</option>
              <option value="Small">Small</option>
              <option value="Medium">Medium</option>
              <option value="Large">Large</option>
            </select>
          </div>
          <div className="mb-4">
            <label htmlFor="lockerStatus" className="block text-gray-700 font-semibold mb-2">Locker Status</label>
            <select
              id="lockerStatus"
              name="lockerStatus"
              value={formData.lockerStatus}
              onChange={handleChange}
              className="w-full px-3 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500"
              required
            >
              <option value="">Select Status</option>
              <option value="Available">Available</option>
              <option value="Occupied">Occupied</option>
            </select>
          </div>
          <div className="mb-4">
            <label htmlFor="lockerPrice" className="block text-gray-700 font-semibold mb-2">Locker Price</label>
            <input
              type="number"
              id="lockerPrice"
              name="lockerPrice"
              value={formData.lockerPrice}
              onChange={handleChange}
              step="0.01"
              className="w-full px-3 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500"
              required
            />
          </div>
          <div className="mb-6">
            <label htmlFor="lockerKeyNumber" className="block text-gray-700 font-semibold mb-2">Locker Key Number</label>
            <input
              type="number"
              id="lockerKeyNumber"
              name="lockerKeyNumber"
              value={formData.lockerKeyNumber}
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

export default LockerMasterForm;