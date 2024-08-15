import React from 'react';
import { useNavigate } from 'react-router-dom';

const LockerManagementDashboard = () => {
    const navigate = useNavigate();
    const handleLogout = () => {
        navigate('/Login')
        };

     const handleDailyVisit = () => {
            navigate('/DailyVisit')
            };

     const handleLockerMaster = () => {
                navigate('/LockerMaster')
                };  
                
    const handleRegister = () => {
                    navigate('/CustomerRegister')
                    };        
     const handleIssue = () => {
                    navigate('/LockerIssue')
                    };                               
    
    
  return (
    <div className="min-h-screen bg-gray-100 p-8">
      <div className="max-w-6xl mx-auto">
        <div className="flex justify-between items-center mb-8">
          <h1 className="text-3xl font-semibold text-gray-800">
            Locker Management System
          </h1>
          <button className="bg-red-500 text-white px-4 py-2 rounded-full hover:bg-red-600 transition-colors"
          onClick={handleLogout}
          > 
            Log Out
          </button>
        </div>
        
        <div className="flex justify-between space-x-4">
          <button
            className="flex-1 bg-blue-500 text-white p-4 rounded-lg shadow-md hover:bg-blue-600 transition-all duration-300 ease-in-out transform hover:scale-130 hover:z-10 flex items-center justify-center w-36 h-36"
            style={{
              aspectRatio: '3.5 / 4.5',
              display: 'flex',
              flexDirection: 'column',
              justifyContent: 'center',
              alignItems: 'center',
              fontSize: '1.1rem',
              textAlign: 'center',
            }}
            onClick={handleLockerMaster}
          >
            Locker Master
          </button>
          
          <button
            className="flex-1 bg-blue-500 text-white p-4 rounded-lg shadow-md hover:bg-blue-600 transition-all duration-300 ease-in-out transform hover:scale-130 hover:z-10 flex items-center justify-center w-36 h-36"
            style={{
              aspectRatio: '2.5 / 3.5',
              display: 'flex',
              flexDirection: 'column',
              justifyContent: 'center',
              alignItems: 'center',
              fontSize: '1.1rem',
              textAlign: 'center',
            }}
            onClick={handleRegister}
          >
            Registration Form
          </button>
          
          <button
            className="flex-1 bg-blue-500 text-white p-4 rounded-lg shadow-md hover:bg-blue-600 transition-all duration-300 ease-in-out transform hover:scale-130 hover:z-10 flex items-center justify-center w-36 h-36"
            style={{
              aspectRatio: '2.5 / 3.5',
              display: 'flex',
              flexDirection: 'column',
              justifyContent: 'center',
              alignItems: 'center',
              fontSize: '1.1rem',
              textAlign: 'center',
            }}
            onClick={handleIssue}
          >
            Locker Issue
          </button>
          
          <button
            className="flex-1 bg-blue-500 text-white p-4 rounded-lg shadow-md hover:bg-blue-600 transition-all duration-300 ease-in-out transform hover:scale-130 hover:z-10 flex items-center justify-center w-36 h-36"
            style={{
              aspectRatio: '2.5 / 3.5',
              display: 'flex',
              flexDirection: 'column',
              justifyContent: 'center',
              alignItems: 'center',
              fontSize: '1.1rem',
              textAlign: 'center',
            }}
            onClick={handleDailyVisit}
          >
            Locker Daily Visit
          </button>
        </div>
      </div>
    </div>
  );
};

export default LockerManagementDashboard;
