import Head from "next/head";
import { useRouter } from "next/router";
import { useEffect, useState } from "react";
import Carousel from "../../components/carousel/Carousel";
import CarouselItem from "../../components/carousel/CarouselItem";
import NavBar from "../../components/NavBar";
import { Rating } from "react-simple-star-rating";

// sample recipe placeholder until API connected
const sampleRecipe: Recipe = {
  id: 1,
  name: "Spaghetti and Meatballs",
  qualityRating: 3,
  difficultyRating: 2.5,
  description: "Classic Italian Spaghetti & Meatballs. Restauraunt style!",
  ingredients: ["Spaghetti", "Meatballs", "Red sauce", "Parmesan cheese"],
  appliances: ["Stovetop"],
  estPrepTime: 10,
  estCookTime: 20,
  imageUrl: "https://images.spot.im/v1/production/nj5fh78jludisdu0nyne",
  instructions: ["Cook spaghetti.", "Cook meatballs.", "Combine", "Serve"],
};

interface Recipe {
  id: number;
  name: string;
  description: string;
  instructions: string[];
  appliances: string[];
  ingredients: string[];
  qualityRating: number;
  difficultyRating: number;
  estCookTime: number;
  estPrepTime: number;
  cusisine: string;
  flavor: string;
  imageUrl: string;
}

export default function RecipePage() {
  const router = useRouter(); // router hook
  const { id } = router.query; // get recipe id from router query param

  const [recipe, setRecipe] = useState<Recipe | undefined>(undefined);

  // get recipe from API
  useEffect(() => {
    setRecipe(sampleRecipe);
  }, []);

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
              className="h-88 w-[35rem] object-cover object-left pointer-events-none select-none"
              src={recipe.imageUrl}
              alt={`Image of ${recipe.name}`}
            />
          )}
          <div className="flex flex-col space-y-5">
            <div className="w-96 h-40 bg-white rounded-md grid grid-cols-2 px-5 py-2 border border-gray-200 select-none">
              <span>
                <p className="font-bold">Prep Time:</p>
                {recipe?.estPrepTime} mins
              </span>
              <span>
                <p className="font-bold">Cook Time:</p>
                {recipe?.estCookTime} mins
              </span>
              <span>
                <p className="font-bold">Total Time:</p>
                {recipe && recipe.estCookTime + recipe.estPrepTime} mins
              </span>
            </div>
            <div className="flex space-x-10 bg-white rounded-md border border-gray-200 px-5 py-4 select-none">
              <div className="flex flex-col space-y-3">
                <h2 className="text-2xl font-bold">Ingredients:</h2>
                <ol className="list-decimal ml-4">
                  {recipe?.ingredients.map((ingredient) => (
                    <li key={ingredient}>{ingredient}</li>
                  ))}
                </ol>
              </div>
              <div className="flex flex-col space-y-3">
                <h2 className="text-2xl font-bold">Appliances:</h2>
                <ol className="list-decimal ml-4">
                  {recipe?.appliances.map((appliance) => (
                    <li key={appliance}>{appliance}</li>
                  ))}
                </ol>
              </div>
            </div>
          </div>
          <Carousel>
            {recipe?.instructions.map((instruction, index) => (
              <CarouselItem key={index}>
                <div className="flex flex-col w-full select-none">
                  <h1 className="text-xl font-semibold mx-auto">
                    Instructions:
                  </h1>
                  <p className="text-lg my-auto">
                    {index + 1}. {instruction}
                  </p>
                </div>
              </CarouselItem>
            ))}
          </Carousel>
        </div>
      </div>
    </div>
  );
}
