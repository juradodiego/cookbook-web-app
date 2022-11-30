import { ChevronRightIcon } from "@heroicons/react/24/outline";
import { useState } from "react";

export default function Login() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const handleLogin = () => {};

  return (
    <div className="bg-white flex flex-col mx-auto mt-40 rounded-md p-4 w-[24rem] focus-within:shadow-md">
      <div className="flex text-3xl select-none mx-auto">
        <h1>Food</h1>
        <h1 className="text-green-500 font-semibold">Dude</h1>
      </div>
      <div className="flex bg-gray-200 rounded-lg h-10 w-[22rem] space-x-2 mt-4 p-2">
        <input
          className="flex-grow rounded-lg focus:outline-none text-gray-800 bg-gray-200"
          type="text"
          placeholder="Username"
          value={username}
          onChange={(e) => setUsername(e.target.value)}
        />
      </div>
      <div className="flex bg-gray-200 rounded-lg h-10 w-[22rem] space-x-2 mt-2 p-2">
        <input
          className="flex-grow rounded-lg focus:outline-none text-gray-800 bg-gray-200"
          type="password"
          placeholder="Password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
        />
      </div>
      <button
        className="mt-3 ml-auto rounded-md p-2 border border-gray-300 bg-gray-200 hover:bg-gray-300 active:bg-gray-400 flex items-center select-none"
        onClick={handleLogin}
      >
        <p className="text-gray-800">Sign In</p>
        <ChevronRightIcon className="h-5" />
      </button>
    </div>
  );
}
