import React from 'react';
import { useNavigate } from 'react-router-dom';

const Login = () => {
    const navigate = useNavigate();

    const handleSignupRedirect = () => {
        navigate('/Register');
    };

    const handleLoginRedirect = () => {
      navigate('/Home');
  };

    return (
        <div className="flex flex-col items-center justify-center h-1/2 bg-gray-100">
          <div className="w-full max-w-sm p-6 bg-white rounded-lg shadow-md">
            <h2 className="text-2xl font-semibold text-center mb-6"> Login</h2>
            <form>
              <div className="mb-4">
                <label className="block text-gray-700 text-sm font-bold mb-2">Email</label>
                <input
                  className="w-full px-3 py-2 text-gray-700 border rounded-lg focus:outline-none focus:shadow-outline"
                  type="email"
                  placeholder="Enter your email"
                />
              </div>
              <div className="mb-6">
                <label className="block text-gray-700 text-sm font-bold mb-2">Password</label>
                <input
                  className="w-full px-3 py-2 text-gray-700 border rounded-lg focus:outline-none focus:shadow-outline"
                  type="password"
                  placeholder="Enter your password"
                />
              </div>
              <button
                className="w-full bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline"
                type="submit"
                onClick={handleLoginRedirect}
              >
                Login
              </button>
            </form>
            <button
              className="mt-4 text-blue-500 hover:text-blue-700 font-bold"
              onClick={handleSignupRedirect}
            >
             Don't have an account? Sign up
            </button>
          </div>
        </div>
    );
};

export default Login;
