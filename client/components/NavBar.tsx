import { NavItem } from "./NavItem";

export default function NavBar() {
  return (
    <div className="bg-white h-20 shadow-md sticky top-0 flex items-center px-5 min-w-full z-50">
      {/* Website Name */}
      <div className="flex text-3xl select-none">
        <h1>Food</h1>
        <h1 className="text-green-500 font-semibold">Dude</h1>
      </div>

      {/* Nav items */}
      <div className="flex flex-grow justify-center space-x-5 mx-auto my-auto select-none">
        <NavItem text="Home" url="/recipes" />
        <NavItem text="Saved Recipes" url="/recipes/saved" />
      </div>

      {/* User Profile */}
      <div className="w-[137.97px]">
        <div className="rounded-full h-10 w-10 bg-black mr-5 ml-auto"></div>
      </div>
    </div>
  );
}
