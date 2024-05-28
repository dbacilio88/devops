import { Injectable } from '@nestjs/common';
import { IRepository } from 'src/components/base/repository.base';
import { InjectRepository } from '@nestjs/typeorm';
import { MongoRepository } from 'typeorm';
import { CategoryDocument } from '../Category.document';

@Injectable()
export class CategoryRepository implements IRepository<CategoryDocument> {

    constructor(
        @InjectRepository(CategoryDocument) private repository: MongoRepository<CategoryDocument>
    ) {
    }

    findAll(query?: any): Promise<CategoryDocument[]> {
        return this.repository.find(query);
    }

    create(document: CategoryDocument): Promise<CategoryDocument> {
        return this.repository.save(document);
    }

    findById(id: string): Promise<CategoryDocument> {
        return this.repository.findOne({
            where: { _id: id }
        })
    }

    findOne(query: any): Promise<CategoryDocument> {
        return this.repository.findOne({
            where: query
        })
    }

    update(id: string, document: CategoryDocument): Promise<any> {
        return this.repository.update(id, document);

    }

    remove(id: string): Promise<any> {
        return this.repository.delete(id);
    }
} 