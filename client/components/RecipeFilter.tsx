import {
  ChevronDoubleRightIcon,
  MagnifyingGlassIcon,
} from "@heroicons/react/24/outline";

export default function RecipeFilter() {
  return (
    <div className="rounded-md w-96 focus-within:shadow-md p-5 bg-white flex flex-col">
      <div className="flex bg-gray-200 rounded-lg h-10 ml-5 w-80 space-x-2">
        <MagnifyingGlassIcon className="ml-2 my-auto h-5 text-gray-700" />
        <input
          className="flex-grow rounded-lg focus:outline-none text-gray-800 bg-gray-200"
          type="text"
          placeholder="Search for recipes"
        />
      </div>
      <ChevronDoubleRightIcon className="h-5 ml-auto mt-auto cursor-pointer" />
    </div>
  );
}
