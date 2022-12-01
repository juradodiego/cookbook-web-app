import { useEffect, useState } from "react";
import NavBar from "../../components/NavBar";
import RecipeWidget from "../../components/RecipeWidget";
import { RecipeWidgetT } from "./index";

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

export default function SavedRecipes() {
  const [savedRecipes, setSavedRecipes] = useState<RecipeWidgetT[] | undefined>(
    undefined
  );

  useEffect(() => {
    // set saved recipes on load
    setSavedRecipes(sampleRecipes);
  });

  return (
    <div>
      <NavBar />
      <div className="flex mx-10 mt-2 flex-wrap">
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
