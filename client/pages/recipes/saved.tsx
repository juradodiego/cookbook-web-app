import { HeartIcon } from "@heroicons/react/24/solid";
import { useEffect, useState } from "react";
import NavBar from "../../components/NavBar";
import RecipeWidget from "../../components/RecipeWidget";
import { getSavedRecipes } from "../../services/recipe";
import { RecipeWidgetT } from "./index";

export default function SavedRecipes() {
  const [savedRecipes, setSavedRecipes] = useState<RecipeWidgetT[] | undefined>(
    undefined
  );

  useEffect(() => {
    const fetchSavedRecipes = async () => {
      const data = await getSavedRecipes();
      setSavedRecipes(data);
    };

    //  the function
    fetchSavedRecipes().catch(console.error);
  }, []);

  return (
    <div>
      <NavBar />
      <div className="ml-20 mt-5 flex select-none items-center space-x-3">
        <h1 className="text-4xl  text-gray-800">Saved Recipes</h1>
        <HeartIcon className="h-10 text-green-700" />
      </div>
      <div className="flex mx-20 mt-5 flex-wrap">
        {savedRecipes?.map((recipe, index) => (
          <RecipeWidget
            name={recipe.name}
            imageUrl={recipe.imageUrl}
            id={recipe.id}
            key={index}
          />
        ))}
      </div>
    </div>
  );
}
