import { useEffect, useState } from "react";
import RecipeWidget from "../../components/RecipeWidget";
import { MagnifyingGlassIcon } from "@heroicons/react/24/outline";

const sampleRecipes: RecipeWidgetT[] = [
  {
    name: "Spaghetti and Meatballs",
    imageUrl:
      "https://hips.hearstapps.com/del.h-cdn.co/assets/17/39/2048x1024/landscape-1506456062-delish-spaghetti-meatballs.jpg?resize=1200:*",
    id: 1,
  },
  {
    name: "Ramen Noodles",
    imageUrl:
      "https://glebekitchen.com/wp-content/uploads/2017/04/tonkotsuramenfront.jpg",
    id: 2,
  },
];

interface RecipeWidgetT {
  name: string;
  imageUrl: string;
  id: number;
}

export default function Home() {
  // recipes from API request (unfiltered)
  const [recipes, setRecipes] = useState<RecipeWidgetT[] | undefined>(
    undefined
  );

  // Search keyword state
  const [searchKeyword, setSearchKeyword] = useState("");

  // Handles search keyword and various filters that a user inputs
  function searchAndFilter(items: RecipeWidgetT[]): RecipeWidgetT[] {
    return items.filter(
      (item) => item.name.toLowerCase().search(searchKeyword.toLowerCase()) > -1
    );
  }

  // initial fetch recipes using search + filter
  useEffect(() => {
    setRecipes(sampleRecipes);
  }, []);

  return (
    <div>
      {/* Search Bar */}
      <div className="flex bg-white rounded-lg h-10 ml-5 mt-5 w-80 focus-within:shadow-lg space-x-2 border border-gray-200">
        <MagnifyingGlassIcon className="ml-2 my-auto h-5 text-gray-700" />
        <input
          className="flex-grow rounded-lg focus:outline-none text-gray-800"
          type="text"
          placeholder="Search for recipes"
          value={searchKeyword}
          onChange={(e) => {
            setSearchKeyword(e.target.value);
          }}
        />
      </div>
      {/* Individual recipe widgets */}
      <div className="flex mx-5 mt-2 space-x-5">
        {recipes &&
          searchAndFilter(recipes).map((recipe) => (
            <RecipeWidget
              name={recipe.name}
              imageUrl={recipe.imageUrl}
              id={recipe.id}
            />
          ))}
      </div>
    </div>
  );
}
