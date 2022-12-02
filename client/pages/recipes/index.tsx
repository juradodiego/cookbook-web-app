import { useEffect, useState } from "react";
import RecipeWidget from "../../components/RecipeWidget";
import NavBar from "../../components/NavBar";
import RecipeFilter from "../../components/RecipeFilter";
import Head from "next/head";
import { getAll } from "../../services/recipe";

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

  // initial fetch recipes using search + filter
  useEffect(() => {
    const fetchRecipes = async () => {
      const data = await getAll();
      setRecipes(data);
    };

    // call the function
    fetchRecipes().catch(console.error);
  }, []);

  return (
    <div>
      <Head>
        <title>FoodDude - Recipes</title>
      </Head>
      <NavBar />
      {/* Search Bar */}
      <div className="flex mt-5 ml-5">
        <RecipeFilter />
        {/* Individual recipe widgets */}
        <div className="flex mx-5 mt-2 flex-wrap">
          {recipes?.map((recipe, index) => (
            <RecipeWidget
              name={recipe.name}
              imageUrl={recipe.imageUrl}
              id={recipe.id}
              key={index}
            />
          ))}
        </div>
      </div>
    </div>
  );
}
