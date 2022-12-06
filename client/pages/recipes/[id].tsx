import Head from "next/head";
import { useRouter } from "next/router";
import { useEffect, useState } from "react";
import Carousel from "../../components/carousel/Carousel";
import CarouselItem from "../../components/carousel/CarouselItem";
import NavBar from "../../components/NavBar";
import { Rating } from "react-simple-star-rating";
import { ChevronLeftIcon, HeartIcon } from "@heroicons/react/24/outline";
import { HeartIcon as FilledHeartIcon } from "@heroicons/react/24/solid";
import Link from "next/link";
import { getById } from "../../services/recipe";
import { getRecipeSaved } from "../../utils/recipes";
interface Recipe {
  id: number;
  name: string;
  description: string;
  instructions: string[];
  appliances: string[];
  ingredients: { ingredient: string; quantity: string };
  qualityRating: number;
  difficultyRating: number;
  estCookTime: number;
  cusisine: string;
  flavor: string;
  imageUrl: string;
}

export default function RecipePage() {
  const router = useRouter(); // router hook
  const id = parseInt(router.query.id as string, 10); // get recipe id from router query param
  const [recipe, setRecipe] = useState<Recipe | undefined>(undefined);
  const [saved, setSaved] = useState(false);

  useEffect(() => {
    const fetchRecipe = async () => {
      const data = await getById(id);
      setRecipe(data);
    };

    // call the function
    if (id) {
      setSaved(getRecipeSaved(id));
      fetchRecipe().catch(console.error);
    }
  }, [id]);

  const saveRecipe = () => {
    if (localStorage.getItem("savedRecipes") == null) {
      const savedRecipes = new Set();
      savedRecipes.add(id);
      const savedRecipesArr = Array.from(savedRecipes);
      localStorage.setItem("savedRecipes", JSON.stringify(savedRecipesArr));
    } else {
      let savedRecipesArr = JSON.parse(localStorage.getItem("savedRecipes"));
      const savedRecipes = new Set(savedRecipesArr);

      if (savedRecipes.has(id)) {
        savedRecipes.delete(id);
      } else {
        savedRecipes.add(id);
      }

      savedRecipesArr = Array.from(savedRecipes);
      localStorage.setItem("savedRecipes", JSON.stringify(savedRecipesArr));
    }

    setSaved(!saved);
  };

  return (
    <div>
      <Head>
        <title>FoodDude {recipe && `- ${recipe.name}`}</title>
      </Head>
      <NavBar />
      <div className="flex flex-col space-y-10">
        <div className="flex flex-col space-y-5 mt-8 text-center">
          <h1 className="text-4xl font-bold font-serif select-none">
            {recipe?.name}
          </h1>
          <div className="flex mx-auto space-x-10">
            <div className="flex flex-col">
              <h2 className="select-none">Quality Rating</h2>
              <Rating
                readonly={true}
                initialValue={recipe?.qualityRating}
                allowFraction={true}
                size={25}
              />
            </div>
            <div className="flex flex-col">
              <h2 className="select-none">Difficulty Rating</h2>
              <Rating
                readonly={true}
                initialValue={recipe?.difficultyRating}
                allowFraction={true}
                size={25}
              />
            </div>
          </div>

          <p className="text-gray-700 text-lg select-none">
            {recipe?.description}
          </p>
        </div>
        <div className="flex space-x-5 mx-auto">
          {recipe?.imageUrl && (
            <img
              className="h-88 2xl:w-[35rem] w-[20rem] object-cover object-left pointer-events-none select-none rounded-md"
              src={recipe.imageUrl}
              alt={`Image of ${recipe.name}`}
            />
          )}
          <div className="flex flex-col space-y-5">
            <div className="w-96 h-40 bg-white rounded-md grid grid-cols-2 px-5 py-2 border border-gray-200 select-none">
              <span>
                <p className="text-2xl font-bold">Cook Time:</p>
                <p className="text-xl">{recipe?.estCookTime} mins</p>
              </span>
            </div>
            <div className="flex space-x-10 bg-white rounded-md border border-gray-200 px-5 py-4 select-none">
              <div className="flex flex-col space-y-3">
                <h2 className="text-2xl font-bold">Ingredients:</h2>
                <ol className="list-decimal ml-4">
                  {recipe?.ingredients &&
                    Object.keys(recipe.ingredients)?.map((ingredient, i) => (
                      <li key={i}>
                        {ingredient}: {recipe?.ingredients[ingredient]},
                      </li>
                    ))}
                </ol>
              </div>
              <div className="flex flex-col space-y-3">
                <h2 className="text-2xl font-bold">Appliances:</h2>
                <ol className="list-decimal ml-4">
                  {recipe?.appliances?.map((appliance) => (
                    <li key={appliance}>{appliance}</li>
                  ))}
                </ol>
              </div>
            </div>
          </div>
          <Carousel>
            {recipe?.instructions?.map((instruction, index) => (
              <CarouselItem key={index}>
                <div className="flex flex-col w-full select-none whitespace-normal">
                  <h1 className="text-xl font-semibold mx-auto">
                    Instructions:
                  </h1>
                  <p className="text-lg my-auto ">
                    {index + 1}. {instruction}
                  </p>
                </div>
              </CarouselItem>
            ))}
          </Carousel>
        </div>
      </div>
      <div className="flex justify-center space-x-10 mt-5">
        <button
          className="pl-2 py-2 pr-3 bg-gray-300 hover:bg-gray-400 active:bg-gray-500 rounded-lg text-gray-800 flex items-center space-x-2 border border-gray-400 select-none"
          onClick={() => router.back()}
        >
          <ChevronLeftIcon className="h-5" />
          <p className="text-lg">Back</p>
        </button>
        <button
          className="pl-2 py-2 pr-3 bg-green-300 hover:bg-green-400 active:bg-green-500 rounded-lg text-gray-800 flex items-center space-x-2 border border-green-400 select-none"
          onClick={saveRecipe}
        >
          <p className="text-lg">{!saved ? "Save Recipe" : "Unsave Recipe"}</p>
          {!saved ? (
            <HeartIcon className="h-5" />
          ) : (
            <FilledHeartIcon className="h-5" />
          )}
        </button>
      </div>
    </div>
  );
}
